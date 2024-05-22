"use server";

import { getSchedule, TAvailability, updateAvailability } from "@/lib/api";

export default async function action(formdata: FormData) {
  const scheduleId = parseInt(formdata.get("scheduleId") as string)
  await updateAvailability({
    scheduleId,
    username: formdata.get("username") as string,
    status: formdata.get("availability") as TAvailability
  })
  const newSchedule = await getSchedule(scheduleId);
  return newSchedule
}
