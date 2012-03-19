/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class TestCaseRun {

    public static class add_comment extends TcmsArrayCommand {

        @RequiredField
        public String caserun_ids;
        @RequiredField
        public String comment;
    }

    public static class attach_bug extends TcmsHashCommand {

        Integer case_run_id;
        Integer bug_id;
        Integer bug_system_id;
        String summary;
        String description;
    }

    public static class check_case_run_status extends TcmsArrayCommand {

        @RequiredField
        public String name;
    }

    public static class create extends TcmsHashCommand {

        @RequiredField
        Integer run;
        @RequiredField
        Integer caseVar;
        @RequiredField
        Integer build;
        @RequiredField
        String asignee;
        Integer case_run_status;
        Integer case_text_version;
        String notes;
        Integer sortkey;
    }

    public static class detach_bug extends TcmsArrayCommand {

        Integer case_run_id;
        Integer object_pks;
    }

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer case_run_id;
    }

    public static class get_bugs extends TestCaseRun.get {
    }

    public static class get_case_run_status extends TestCaseRun.get {
    }

    public static class get_completion_time extends TestCaseRun.get {
    }

    public static class update extends TcmsArrayCommand {

        @RequiredField
        public Integer id;
        public update.Values values = new Values();

        public static class Values extends TcmsHashCommand {

            Integer build;
            String asignee;
            Integer case_run_status;
            String notes;
            Integer sortkey;
        }
    }
}
