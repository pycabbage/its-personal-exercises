export default function genDate(date: Date | undefined = undefined): string {

  const tomorrow = date ?? new Date(Date.now() + 24 * 60 * 60 * 1000);

  // 年、月、日を取得
  const year = tomorrow.getFullYear();
  const month = String(tomorrow.getMonth() + 1).padStart(2, '0'); // 月は0から始まるので+1
  const day = String(tomorrow.getDate()).padStart(2, '0');

  // フォーマットを設定
  const formattedDate = `${year}-${month}-${day}`;
  return formattedDate
}
