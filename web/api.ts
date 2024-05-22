const API_BASE_URL = "http://localhost:8080/"

async function getSchedule(id: number) {
  const req = await fetch(`${API_BASE_URL}schedule`)
  const url = new URL(
    `/schedule`,
    API_BASE_URL
  )

}
