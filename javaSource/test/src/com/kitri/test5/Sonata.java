package com.kitri.test5;

public class Sonata extends Car {
	private String series;
	private String use;
	
	//생성자
	public Sonata(String color, int account, String series, String use) {
		super(color, account);
		this.series = series;
		this.use = use;
	}
	
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	@Override
	public String toString() {
		String info = super.toString();
		info += "\t[용도] " + getUse() + "\t[시리즈] " + getSeries();
		return info;
	}
	
	public static void main(String[] args) {
		Sonata sonata1 = new Sonata("흰색", 5000, "NF", "승용"	);
		Sonata sonata2 = new Sonata("은색", 7000, "Brilliant", "업무"	);
		Sonata sonata3 = new Sonata("감홍색", 4000, "EF", "택시"	);
		Sonata sonata4 = new Sonata("검정색", 6000, "Hybrid", "승용"	);
	
		Sonata sonataArray[] = new Sonata[4];
		sonataArray[0] = sonata1;
		sonataArray[1] = sonata2;
		sonataArray[2] = sonata3;
		sonataArray[3] = sonata4;
		
		int len = sonataArray.length;
		for (int i = 0; i < len; i++) {
			System.out.println(sonataArray[i]);
		}
	}
}
