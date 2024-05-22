import { z } from "zod"

function env(name: string): string {
  const value = process.env[name]
  if (value === undefined) {
    throw new Error(`Missing environment variable: ${name}`)
  }
  return value
}

const API_BASE_URL = `http://${env("API_HOST")}:8080/`

export const zAvailability = z.union([
  z.literal("YES"),
  z.literal("NO"),
  z.literal("MAYBE"),
])
export type TAvailability = z.infer<typeof zAvailability>

export const zSchedule = z.object({
  scheduleId: z.number(),
  date: z.string(),
  title: z.string(),
  availability: z.array(z.object({
    availabilityId: z.number(),
    username: z.string(),
    status: zAvailability
  }))
})
export type TSchedule = z.infer<typeof zSchedule>
export const getSchedule = z.function(
  z.tuple([z.number()]),
  zSchedule.promise()
).implement(async (id) => {
  const url = new URL(
    `/schedule`,
    API_BASE_URL
  )
  url.searchParams.append("id", id.toString())
  const req = await fetch(url)
  return await req.json() as TSchedule
})

const zCreateSchedule = z.object({
  title: z.string(),
  date: z.string().or(z.date()),
  username: z.string(),
  status: zAvailability
})
export const createSchedule = z.function(
  z.tuple([zCreateSchedule]),
  z.number().promise()
).implement(async (create) => {
  const url = new URL(
    `/schedule`,
    API_BASE_URL
  )
  url.searchParams.append("title", create.title)
  url.searchParams.append("date", typeof create.date === "string" ? create.date : create.date.toISOString())
  url.searchParams.append("username", create.username)
  url.searchParams.append("status", create.status)
  const res = await fetch(url, {
    method: "POST",
  })
  return parseInt(await res.text())
})

const zUpdateAvailability = z.object({
  scheduleId: z.number(),
  username: z.string(),
  status: zAvailability
})
export const updateAvailability = z.function(
  z.tuple([zUpdateAvailability]),
  z.void().promise()
).implement(async (update) => {
  const url = new URL(
    `/schedule`,
    API_BASE_URL
  )
  url.searchParams.append("scheduleId", update.scheduleId.toString())
  url.searchParams.append("username", update.username)
  url.searchParams.append("status", update.status)
  await fetch(url, {
    method: "PUT",
  })
  return
})

