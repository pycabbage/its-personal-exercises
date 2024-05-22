"use client";

import { useState } from "react";
import action from "./action";
import SubmitButton from "./SubmitButton";
import { TAvailability, TSchedule, updateAvailability } from "@/lib/api";

interface UpdateFormProps {
  scheduleId: number;
  schedule: TSchedule;
}
export default function UpdateForm({
  scheduleId,
  schedule
}: UpdateFormProps) {
  const [sc, setSc] = useState(schedule);

  return <>
    <form
      action={async formData => {
        const result = await action(formData)
        setSc(result)
      }}
      className="flex flex-col gap-4"
    >
      <input type="text" required placeholder="名前" className="input input-bordered" name="username" id="username" />
      <input type="hidden" name="scheduleId" value={scheduleId} />
      <div className="join flex justify-center ">
        <input className="join-item btn" type="radio" name="availability" required aria-label="暇" value="YES" />
        <input className="join-item btn" type="radio" name="availability" required aria-label="ほどほど" value="MAYBE" />
        <input className="join-item btn" type="radio" name="availability" required aria-label="忙しい" value="NO" />
      </div>
      <SubmitButton />
    </form>
    <div className="overflow-x-auto">
      <table className="table">
        <thead>
          <tr>
            <th>名前</th>
            <th>暇？</th>
          </tr>
        </thead>
        <tbody>
          {sc.availability.map(({ username, status }, i) => (
            <tr key={i}>
              <td>{username}</td>
              <td>{{
                YES: "暇",
                MAYBE: "ほどほど",
                NO: "忙しい"
              }[status]}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  </>
}
