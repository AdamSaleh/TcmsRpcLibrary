
package com.redhat.nitrate.command;

import com.redhat.nitrate.RequiredField;
import com.redhat.nitrate.TcmsArrayCommand;
import com.redhat.nitrate.TcmsHashCommand;

/**
 *
 * @author asaleh
 */
public class TestCaseRun {

    public static final int IDLE=1;
    public static final int PASSED=2;
    public static final int FAILED=3;
    public static final int RUNNING=4;
    public static final int PAUSED=5;
    public static final int BLOCKED=6;
    public static final int ERROR=7;
    public static final int WAIVED=8;
    
    public Integer case_run_status_id;
    public String case_run_status;
    public String running_date;
    public Integer case_run_id;
    public String tested_by_id;
    public Integer case_text_version;
    public String assignee;
    public String close_date;
    public String build;
    public String run;
    public String tested_by;
    public Integer run_id;
    public Integer assignee_id;
    public String cortkey;
    public Integer case_id;
    public Integer build_id;    
    public String caseVar;
    public Integer environment_id;
    public Boolean is_current;
    public String notes;
    

    public static class add_comment extends TcmsArrayCommand {

        @RequiredField
        public String caserun_ids;
        @RequiredField
        public String comment;
    }

    public static class attach_bug extends TcmsHashCommand {

        public Integer case_run_id;
        public Integer bug_id;
        public Integer bug_system_id;
        public String summary;
        public String description;
    }

    public static class check_case_run_status extends TcmsArrayCommand {

        @RequiredField
        public String name;
    }

    public static class create extends TcmsHashCommand {

        @RequiredField
        public Integer run;
        @RequiredField
        public Integer caseVar;
        @RequiredField
        public Integer build;
        @RequiredField
        public String asignee;
        public Integer case_run_status;
        public Integer case_text_version;
        public String notes;
        public Integer sortkey;
    }

    public static class detach_bug extends TcmsArrayCommand {

        public Integer case_run_id;
        public Integer object_pks;
    }

    public static class filter extends TcmsHashCommand {

        public Integer build;
        public Integer run;
        public Integer caseVar;
        public Integer category;
        public Integer case_run_status;
        
        
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

            public Integer build;
            public String asignee;
            public Integer case_run_status;
            public String notes;
            public Integer sortkey;
        }
    }
}
