package com.lti.flight;

public class Flight {

		private int fno;
		private String fname;
		private String toCity;
		private String fromCity;
		
		public Flight() {
		
		}
		
		public Flight(int fno, String fname, String toCity, String fromCity) {
			super();
			this.fno = fno;
			this.fname = fname;
			this.toCity = toCity;
			this.fromCity = fromCity;
		}

		public int getFno() {
			return fno;
		}

		public void setFno(int fno) {
			this.fno = fno;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getToCity() {
			return toCity;
		}

		public void setToCity(String toCity) {
			this.toCity = toCity;
		}

		public String getFromCity() {
			return fromCity;
		}

		public void setFromCity(String fromCity) {
			this.fromCity = fromCity;
		}
		
		
		
}
