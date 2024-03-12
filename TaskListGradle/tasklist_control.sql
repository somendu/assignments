
-- Just keeping it for reference 

SELECT i_task_id, t_task_input_date taskInputDate, c_task_list taskList, c_cons_name consName 
			FROM tasklist WHERE t_task_input_date BETWEEN '01-06-2020' AND '30-06-2020' AND c_cons_name = 'Somendu Maiti' ORDER BY t_task_input_date;
            
            
DELETE from tasklist 
Where i_task_id in (84,
82,
81,
101,
121, 122);