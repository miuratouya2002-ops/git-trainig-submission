
//InstantとZonedDataTimeを利用する
import java.time.Instant;
import java.time.ZoneId;

public class Main15_14 {

	public static void main(String[] args) {
		//Instantの生成
		//メモ↓現在日時を取得
		Instant i1 = Instant.now();
		//Instantとlong値との相互変換
		//メモ↓
		//　　　1600705425827Lはlong
		Instant i2 = Instant.ofEpochMilli(1600705425827L);
		long l = i2.toEpochMilli();
		
		//ZonedDataTimeの生成
		//メモ↓
		ZonedDataTime z1 = ZonedDataTime.now();
		ZonedDataTime z2 = ZonedDataTime
				.of(2023, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));
		
		//ZonedDataTimeの利用方法
		System.out.println("東京:" +
		   z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		System.out.println("ロンドン:" +
		   z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
		if (z2.isEqual(z3)) {
			System.out.println("これらは同じ瞬間を指しています");
		}
	}
}