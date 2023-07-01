package com.baek.lookforcomment.model;

import java.sql.Timestamp;

public class LookforReplyVO {
		
		private String idx;
		private String parentidx;
		private String body;
		private String id;
		private Timestamp regdate; // 추가멤버 (이름) 

		public LookforReplyVO() {
			// TODO Auto-generated constructor stub
		}

		public LookforReplyVO(String idx, String parentidx, String body, String id, Timestamp regdate) {
			super();
			this.idx = idx;
			this.parentidx = parentidx;
			this.body = body;
			this.id = id;
			this.regdate = regdate;
		}

		public String getIdx() {
			return idx;
		}

		public void setIdx(String idx) {
			this.idx = idx;
		}

		public String getParentidx() {
			return parentidx;
		}

		public void setParentidx(String parentidx) {
			this.parentidx = parentidx;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Timestamp getRegdate() {
			return regdate;
		}

		public void setRegdate(Timestamp regdate) {
			this.regdate = regdate;
		}
		
		
}
