public class Exercise14 {
    public static void main(String[] args) {

        int gradeLevel = 12;

        boolean isSenior = gradeLevel == 12;
        System.out.println(isSenior);


        boolean isInterestedInVolunteering = true;

        boolean shouldSendVolunteerInfo;

        shouldSendVolunteerInfo = isSenior && isInterestedInVolunteering;

        System.out.println(shouldSendVolunteerInfo);

    }
}
