
-- Drop existing objects.
DROP SEQUENCE tasklist_seq;
DROP TABLE tasklist;

-- Create table.
CREATE TABLE tasklist (
			i_task_id integer primary key USING INDEX (CREATE INDEX ix_i_task_id ON tasklist(i_task_id)),
			c_cons_name	varchar2(50),
			t_task_input_date date default sysdate,
			c_task_list varchar2(200),
			i_status	integer default 0,
			c_input_user	varchar2(50),
			t_input_date	date default sysdate,
			c_update_user	varchar2(50),
			t_update_date	date,
			CONSTRAINT c_cons_name_unique UNIQUE (c_cons_name)
			);

-- Create sequence.
CREATE SEQUENCE tasklist_seq START WITH 1 INCREMENT BY 1 NOMAXVALUE;

-- Create trigger.
CREATE OR REPLACE TRIGGER tasklist_trigger
BEFORE INSERT ON tasklist
FOR EACH ROW WHEN (NEW.i_task_id IS NULL)
BEGIN
	SELECT	tasklist_seq.NEXTVAL
	INTO	:NEW.i_task_id
	FROM	DUAL;
END;
/

COMMIT;
