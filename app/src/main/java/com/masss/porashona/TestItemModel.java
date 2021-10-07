package com.masss.porashona;

import android.widget.Toast;

import java.util.Comparator;

public class TestItemModel {
    String id;
    String subject;
    Integer totalmarks;
    Integer obtainedmarks;
    Integer correctattempt;
    Integer wrongattempt;
    Integer unattempt;

    public TestItemModel(String id, String subject, Integer totalmarks, Integer obtainedmarks, Integer correctattempt, Integer wrongattempt, Integer unattempt) {
        this.id = id;
        this.subject = subject;
        this.totalmarks = totalmarks;
        this.obtainedmarks = obtainedmarks;
        this.correctattempt = correctattempt;
        this.wrongattempt = wrongattempt;
        this.unattempt = unattempt;
    }



    static class WeakSortingComparator implements Comparator<TestItemModel> {

        @Override
        public int compare(TestItemModel test1, TestItemModel test2) {

            Integer test1p = (test1.obtainedmarks * 100) / test1.totalmarks;
            Integer test2p = (test2.obtainedmarks * 100) / test2.totalmarks;
            System.out.println(test1p+" "+test2p);
            return test1p - test2p;
        }
    }

    static class StrongSortingComparator implements Comparator<TestItemModel> {

        @Override
        public int compare(TestItemModel test1, TestItemModel test2) {

            Integer test1p = (test1.obtainedmarks * 100) / test1.totalmarks;
            Integer test2p = (test2.obtainedmarks * 100) / test2.totalmarks;
            return test2p - test1p;
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(Integer totalmarks) {
        this.totalmarks = totalmarks;
    }

    public Integer getObtainedmarks() {
        return obtainedmarks;
    }

    public void setObtainedmarks(Integer obtainedmarks) {
        this.obtainedmarks = obtainedmarks;
    }

    public Integer getCorrectattempt() {
        return correctattempt;
    }

    public void setCorrectattempt(Integer correctattempt) {
        this.correctattempt = correctattempt;
    }

    public Integer getWrongattempt() {
        return wrongattempt;
    }

    public void setWrongattempt(Integer wrongattempt) {
        this.wrongattempt = wrongattempt;
    }

    public Integer getUnattempt() {
        return unattempt;
    }

    public void setUnattempt(Integer unattempt) {
        this.unattempt = unattempt;
    }
}
