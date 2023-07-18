Feature: Jobcode page validation 

Scenario: Join us form validation 
	Given the user is on the join us page 
	When the user enters the following details in the form: 
	
|NAME   |EMAIL                     |PHONE           |NOTICE PERIOD   |EXPERIENCE|DESCRIPTION          |Scenario|
|Sharad |sharadingale2124@gmail.com|8600841365      |15              |4         |This is join us 1st  |Possitive|
|nawaz  |Nawaz21gmail.com          |1234567890      |5               |0         |This is join us 2nd  |Negative|
|dipali |Dip21@gmail.co            |+9186008413     |5               |0         |This is join us 3rd  |Negative|
|Ramesh |Ramngale21@gmail.com      |+9186008413     |4               |8         |This is join us last |Negative|
		
	And the user submits the form by clicking on the Apply Now button 
	Then the form should be submitted successfully with possitive scenario "String"
	
  