import SubmitButton from "@/components/SubmitButton";
import UpdateForm from "@/components/updateForm";
import { getSchedule, TAvailability, updateAvailability } from "@/lib/api";
import Link from "next/link";
import { redirect } from "next/navigation";

export default async function Schedule({ params: { id } }: { params: { id: string } }) {
  const scheduleId = parseInt(id)
  const schedule = await getSchedule(scheduleId);

  return <main className="font-semibold my-8 flex flex-col gap-4 mx-8 lg:mx-[30vw]">
    <Link href="/" className="text-xl text-bold text-center">
      シンプル予定調整
    </Link>

    <Link href={`/${scheduleId}`} className="text-3xl text-bold text-center">
      {schedule.title}
    </Link>
    
    <UpdateForm scheduleId={scheduleId} schedule={schedule} />
  </main>
}
