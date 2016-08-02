package com.example.android.grades;

import java.util.ArrayList;

/**
 * Created by bplewis5 on 6/26/16.
 */
public class ReportCard {

    private ArrayList<Course> mCourses;
    private double mGPA = calculateGPA(mCourses);

    ReportCard(ArrayList<Course> courses) {
        mCourses = courses;
    }

    private double calculateGPA(ArrayList<Course> courses) {
        double gPA = 0d;
        for (Course course : courses) {
            gPA += course.getGradeOnFourPointScale();
        }
        return gPA / courses.size();
    }

    @Override
    public String toString(){
        String message = "Report Card: ";
        for (Course course : mCourses){
            message += "\n" + course.toString();
        }
        message += "\nSemester GPA: " + mGPA;
        return message;
    }

    public class Course {
        private String mCourseTitle;
        // Final percentage score for course
        // e.g. a 93.2% final score for a course would written 93.2
        private double mFinalPercentScore;
        private char mLetterGrade = convertToLetterGrade(mFinalPercentScore);

        Course(String courseTitle, double finalpercentScore) {
            mCourseTitle = courseTitle;
            mFinalPercentScore = finalpercentScore;
        }

        public String getCourseTitle() {
            return mCourseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            mCourseTitle = courseTitle;
        }

        public double getFinalPercentScore() {
            return mFinalPercentScore;
        }

        public void setPercentScore(double percentScore) {
            mFinalPercentScore = percentScore;
        }

        public char getLetterGrade() {
            return mLetterGrade;
        }

        public double getGradeOnFourPointScale() {
            return convertToLetterGrade(mLetterGrade);
        }

        public char convertToLetterGrade(double finalPercentScore) {
            if (finalPercentScore > 90d) {
                return 'A';
            }
            if (finalPercentScore > 80d) {
                return 'B';
            }
            if (finalPercentScore > 70d) {
                return 'C';
            }
            if (finalPercentScore > 60d) {
                return 'D';
            }
            return 'F';
        }

        public double toFourPointScale(char grade) {
            switch (grade) {
                case 'A':
                    return 4d;
                case 'B':
                    return 3d;
                case 'C':
                    return 2d;
                case 'D':
                    return 1d;
                default:
                    return 0d;
            }
        }
        @Override
        public String toString(){
            return mCourseTitle + ":     " + mLetterGrade;}
    }
}