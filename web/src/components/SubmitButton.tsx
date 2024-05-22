"use client";

import { useFormStatus } from "react-dom"

export default function SubmitButton() {
  const { pending } = useFormStatus()
  return <input type="submit" className="btn" value={pending ? "送信中..." : "送信"} disabled={pending} />
}
