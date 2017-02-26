package org.base.system.enumeration;

/**
 * 枚举定义
 * 
 */
public class Enumerations {

	/**
	 * 状态枚举
	 */
	public enum Status {
		不可用(0), 可用(1);
		int status;

		private Status(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}

		public static Status getStatus(int status) {
			switch (status) {
			case 0:
				return 不可用;
			case 1:
				return 可用;
			default:
				return 不可用;
			}
		}
	}

	// 考试状态
	public enum TestStatus {
		未做(0), 已做(1), 已删除(2);
		int status;

		private TestStatus(int status) {
			this.status = status;
		}

		public int getTestStatus() {
			return status;
		}

		public static TestStatus getTestStatus(int status) {
			switch (status) {
			case 0:
				return 未做;
			case 1:
				return 已做;
			case 2:
				return 已删除;
			default:
				return 未做;
			}
		}
	}

}
