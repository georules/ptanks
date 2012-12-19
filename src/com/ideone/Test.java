package com.ideone;

public class Test {
	public static void main(String args[]) throws Exception{
		long startTime = System.currentTimeMillis();
		Ideone engine = new Ideone();
		String source = "a=10\na=a*2\nprint a";
		String link = engine.createSubmission(source, engine.getLanguageIdByName("Python"), "", true, false);
		IdeoneSubmissionStatus status = engine.getSubmissionStatus(link);
		while (status.status == 1) {
			Thread.sleep(1000);
			status = engine.getSubmissionStatus(link);
		}
		IdeoneSubmissionDetails isd = engine.getSubmissionDetails(link, false, false, true, true, true);
		System.out.println(isd.output);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime -startTime)/1000);
	}
}
