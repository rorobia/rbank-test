# rbank

This is a simple spring boot application that generates project schedule based on the task dependencies(subtasks) and duration.


To run the application:
***
Upon cloning the project, run the project in the project root directory using `mvn spring-boot:run`

The project will initialize at port(s): 8080 (http). There is only 1 endpoint at `http://localhost:8080/calendar-schedule` using `GET` request.

`Sample cURL Request`
```
curl --location --request GET 'http://localhost:8080/calendar-schedule' \
--header 'Content-Type: application/json' \
--data-raw '[
    	{
		"duration": 1,
        	"name": "Garden Mowing"
	},
	{
        	"name": "Room Renovation",
		"duration": 3,
		"subTasks" : [
			{
				"duration" : 2,
                		"name": "Cleaning"
			},
			{
				"duration" : 2,
                		"name": "Repaint"
			}
		]
	}
]'
```

`Request Structure`
```
 duration - `Long` value for number of days
 name - `String` value for task name
 subtask - Array of task where the task is dependent
```

`Sample Response`

```
[
    {
        "duration": 1,
        "name": "Garden Mowing",
        "startDate": "2023-02-09",
        "endDate": "2023-02-10",
        "subTasks": []
    },
    {
        "duration": 3,
        "name": "Room Renovation",
        "startDate": "2023-02-15",
        "endDate": "2023-02-18",
        "subTasks": [
            {
                "name": "Cleaning",
                "duration": 2,
                "startDate": "2023-02-09",
                "endDate": "2023-02-11"
            },
            {
                "name": "Repaint",
                "duration": 2,
                "startDate": "2023-02-12",
                "endDate": "2023-02-14"
            }
        ]
    }
]
```


`Response Structure`
```
 duration - `Long` value for number of days
 name - `String` value for task name
 subtask - Array of task where the task is dependent
 startDate - date when will the task/subtask starts
 endDate - date when will task/subtask ends

 (Note that the start date on the parent task always depends on subtask end dates, if any)
 (Also, added a service impl test that tests the code via junit.)
```
