import SubmitButton from "@/components/SubmitButton";
import { createSchedule, TAvailability } from "@/lib/api";
import genDate from "@/lib/genDate";
import Link from "next/link";
import { redirect } from "next/navigation";

export default async function Home() {
  const date = genDate();
  return (
    <main className="text-xl font-semibold my-8">
      <form
        action={async formdata => {
          "use server";
          const scheduleId = await createSchedule({
            title: formdata.get("title") as string,
            date: formdata.get("date") as string,
            username: formdata.get("username") as string,
            status: formdata.get("availability") as TAvailability
          })
          redirect(`/${scheduleId}`)
        }}
        className="flex flex-col gap-4 mx-8 lg:mx-[30vw]"
      >
        <Link href="/" className="text-xl text-bold text-center">
          シンプル予定調整
        </Link>
        <input type="text" required placeholder="タイトル" className="input input-bordered" name="title" id="title" />
        <input type="text" required placeholder="名前" className="input input-bordered" name="username" id="username" />
        <input type="date" required placeholder="日付" className="input input-bordered" name="date" id="date" defaultValue={date} />
        <div className="join flex justify-center ">
          <input className="join-item btn" type="radio" name="availability" required aria-label="暇" value="YES" />
          <input className="join-item btn" type="radio" name="availability" required aria-label="ほどほど" value="MAYBE" />
          <input className="join-item btn" type="radio" name="availability" required aria-label="忙しい" value="NO" />
        </div>
        <SubmitButton />
      </form>
    </main>
  );
}
