# Smart-Agriculture
This project demonstrates the integration of IoT devices with agriculture to create a smart farming system. It utilizes sensors like DHT11 for temperature and humidity and a soil moisture sensor, all connected through Node MCU with an ESP8266 chip. Data collected from the sensors is transmitted to a Firebase real-time database, where it is analyzed and used to optimize farming processes. The project also includes an Android application for real-time monitoring, providing an efficient and automated approach to modern agriculture, reducing waste, and increasing productivity.

# App Screen Shots

<img width="352" alt="Screen Shot 2022-06-12 at 6 41 03 PM" src="https://user-images.githubusercontent.com/53705624/173234299-bd19b7c4-a9b1-425b-9e34-67b762c50572.png">

Dashboard Page


<img width="343" alt="Screen Shot 2022-06-12 at 6 42 04 PM" src="https://user-images.githubusercontent.com/53705624/173234347-7aa7872d-80fc-46f7-b4b4-823c41c8def1.png">

Add Crop Page

<img width="343" alt="Screen Shot 2022-06-12 at 6 42 52 PM" src="https://user-images.githubusercontent.com/53705624/173234389-c1f730c7-4218-442c-a2b4-a732b6739ae6.png">

Live Data


<img width="343" alt="Screen Shot 2022-06-12 at 6 43 19 PM" src="https://user-images.githubusercontent.com/53705624/173234400-5f27cfaa-9c22-4f1e-859c-4d9808bb88f1.png">

Moisture Log


<img width="343" alt="Screen Shot 2022-06-12 at 6 43 51 PM" src="https://user-images.githubusercontent.com/53705624/173234415-9ce7672f-6a02-4055-aca8-2fe96cb5eba6.png">

Humidity Log


<img width="343" alt="Screen Shot 2022-06-12 at 6 44 13 PM" src="https://user-images.githubusercontent.com/53705624/173234435-dd544bea-2e06-413e-b517-a8ade6878b1f.png">

Temperature Log


<img width="343" alt="Screen Shot 2022-06-12 at 6 44 33 PM" src="https://user-images.githubusercontent.com/53705624/173234454-99d0df72-91c3-422b-b202-a58d3f7c1a79.png">

Cost Estimation


<img width="343" alt="Screen Shot 2022-06-12 at 6 45 42 PM" src="https://user-images.githubusercontent.com/53705624/173234506-e9f08810-5629-47d2-adf8-3eb1a47e0823.png">

Performace Tracker


# User Guidelines

1.	User Guidelines

This guideline is for end-users who have installed “Smart Agriculture” and are looking for an instruction to fully understand the usage of the application. Therefore, multiple instructions intended to help the end user understand the app are provided below: 

1.1.	Selecting Crop

The purpose of this application is to help end users (farmers) to better their farming through incorporation of technologies. Hence, understanding the crop type is a very crucial part for using this application. Smart Agriculture makes it easy for the end user to enter crop details as the dashboard contains “Add Crops” option as highlighted in figure 1 by a rectangle brown box. 

<img width="296" alt="Screen Shot 2022-06-12 at 6 49 15 PM" src="https://user-images.githubusercontent.com/53705624/173234612-e4ea050c-4143-42b5-9757-181da607fcc0.png">

Figure 1: Dashboard of Smart Agriculture


After selecting the crop following page will be shown on the mobile screen. This is demonstrated by figure 2. After choosing any of the provided option the database will automatically add data relating to the particular crop.
 
<img width="294" alt="Screen Shot 2022-06-12 at 7 20 03 PM" src="https://user-images.githubusercontent.com/53705624/173235812-e2cb268a-0e81-451d-965d-9297c3844511.png">

Figure 2: Choose Crop Page

For example, if the end user wants the sensor to read data for rice, the rice option should be selected as shown in figure 3. Also, a message will be displayed alerting the end user’s action which is also shown in figure 3.

<img width="294" alt="Screen Shot 2022-06-12 at 7 20 30 PM" src="https://user-images.githubusercontent.com/53705624/173235824-ebca78a2-02ab-47e6-b227-186d90ad5b95.png">

Figure 3: Adding Crops


1.2.	Viewing Live Data

Another main purpose of application is to read live data from the field itself. This action can be performed by choosing the Live Data option as specified in figure 4 by an orange rectangle.
 
 
<img width="294" alt="Screen Shot 2022-06-12 at 7 21 09 PM" src="https://user-images.githubusercontent.com/53705624/173235842-695dc74b-d5d5-493f-a604-b1d5013552ad.png">

Figure 4: Dashboard of Smart Application

Upon choosing the option the live data page will open as shown in figure 5. At once 8 different data can be read and displayed on the screen which can be seen highlighted on figure 5 by an orange rectangle box.

<img width="294" alt="Screen Shot 2022-06-12 at 7 22 02 PM" src="https://user-images.githubusercontent.com/53705624/173235877-5f743d87-a95a-4d08-9367-fa7d2e29179d.png">

Figure 5: Live Data Page


1.3.	Moisture, Temperature, and Humidity Log

The whole concept of better farming revolves around data, the more data is accumulated the more accurate prediction can be given such as if the temperature and humidity is favorable for growing a particular crop. Hence, identifying these parameters on a daily basis is important for which log are created. Following figure 6 shown the options for the moisture, temperature, and humidity log. 

<img width="575" alt="Screen Shot 2022-06-12 at 7 22 48 PM" src="https://user-images.githubusercontent.com/53705624/173235900-96b3fffe-09ae-42f8-9b31-2cfdf23e1e76.png">
  
Figure 6: Dashboard Page

Following figure 7 shows the moisture log where a green dotted line is the optimum moisture required for the specified crop. Similarly, red line signifies either the moisture is low or high depending if the line is upward then the green dotted line or below it.

 
<img width="342" alt="Screen Shot 2022-06-12 at 7 24 33 PM" src="https://user-images.githubusercontent.com/53705624/173235981-8970fe44-7122-4352-b446-82ee602a3d38.png">

Figure 7: Moisture Log

Similarly, the following figure 8 is a humidity log where data are shown in a graphical form.

<img width="342" alt="Screen Shot 2022-06-12 at 7 24 53 PM" src="https://user-images.githubusercontent.com/53705624/173235994-9df79855-ff86-4101-a4e1-9a30fdb357f9.png">

Figure 8: Humidity Log

Also figure 9 shows the temperature log

<img width="342" alt="Screen Shot 2022-06-12 at 7 25 17 PM" src="https://user-images.githubusercontent.com/53705624/173236014-a7ae77bd-41e9-4574-a040-4de84ce503b1.png">

Figure 9: Temperature Log

1.4.	Cost Calculation

The end user is facilitated with an additional feature of cost estimation where the cost of growing the crop can be known. For choosing this facility, the option highlighted in figure 10 should be choose.


<img width="354" alt="Screen Shot 2022-06-12 at 7 26 30 PM" src="https://user-images.githubusercontent.com/53705624/173236079-feeb1e46-32ed-4d18-8092-9c1483d02254.png">

Figure 10: Dashboard Page

As the following figure 11 numerical entry should be entered and calculate button should be clicked for generating the output.


<img width="354" alt="Screen Shot 2022-06-12 at 7 26 49 PM" src="https://user-images.githubusercontent.com/53705624/173236085-ddd9d527-1d94-45d8-ba7f-1387c8f10fec.png">

Figure 11: Calculate EMI

1.5.	Starting Analysis

For starting the analysis, the start reading button should be clicked as highlighted in the figure 12.

<img width="354" alt="Screen Shot 2022-06-12 at 7 27 41 PM" src="https://user-images.githubusercontent.com/53705624/173236121-3f858b2e-5516-46ea-a2ad-633c0c02e563.png">
 
Figure 12: Dashboard

Following page will be seen in the page the top section with a progress bar is the performance rating which in this case of 98. 

<img width="354" alt="Screen Shot 2022-06-12 at 7 27 55 PM" src="https://user-images.githubusercontent.com/53705624/173236131-5f1d6df2-0091-4cc5-a866-ccf33a4dc363.png">
 
Figure 13: Data Analysis Page


# Installation Guidelines 

1.1.	Download ZIP folder 
Download the zip folder that contains the source code. The source code contains one files containing ever components needed to successfully run the application. 

1.2.	Download Android Studio 
Android Studio should be installed as this application is an android-based application. The installation can be done from ‘https://developer.android.com’. After the app successfully run in the computer it would look something like in figure 1.

<img width="533" alt="Screen Shot 2022-06-12 at 8 16 23 PM" src="https://user-images.githubusercontent.com/53705624/173238112-811e1041-d686-4d3c-bab0-3f50d273ac0c.png">

Figure 1: Starting Android Studio

1.3.	Open the file from Android Studio 

Now everything is ready for the running the app in the android studio. For this the folder should be opened form the android studio by clicking on open button as shown in the figure 2. 


<img width="533" alt="Screen Shot 2022-06-12 at 8 16 59 PM" src="https://user-images.githubusercontent.com/53705624/173238134-d3a72854-6845-4b4c-975e-cadc3177c5e8.png">

Figure 2: Android Studio

1.4.	Run Application

Now the application can be run by clicking on the play bottom on top of the android studio as highlighted by in figure 3.

<img width="476" alt="Screen Shot 2022-06-12 at 8 17 30 PM" src="https://user-images.githubusercontent.com/53705624/173238160-fd1befa1-6d89-415a-8502-957bd4c4ff16.png">

Figure 3: Android Studio

After the run button is clicked following figure 7 screen will appear. Although the screen might take some time to appear as the installation is done for the very first time.

<img width="451" alt="Screen Shot 2022-06-12 at 8 18 00 PM" src="https://user-images.githubusercontent.com/53705624/173238183-41c63482-c455-4fce-be7c-6406131eebeb.png">
 
Figure 4: Application Run Successfully



# IoT Device Used 

![Picture1](https://user-images.githubusercontent.com/53705624/173233681-633758f2-3f03-4d6e-b254-cbacea9be89f.png)

Node MCU with ESP8266 chip 



![Picture2](https://user-images.githubusercontent.com/53705624/173233695-6d47957d-968c-4df1-8c06-615bcb09e6f6.png)

DHT11 sensor for reading temperature and realtive humidity value



![Picture3](https://user-images.githubusercontent.com/53705624/173233729-c48aa166-fa13-4657-8ab3-9d03d107bf44.png)

Soil Moisture Sensor


#Device Setup 

![Picture7](https://user-images.githubusercontent.com/53705624/173233811-c1a4ed5b-4d61-4878-b244-d0988f7487b1.png)

![287178044_550099679896031_5877306972777459868_n](https://user-images.githubusercontent.com/53705624/173233953-e281ea89-b9be-4afc-a94c-59c2d2c007fd.jpg)

![287322067_570767871113935_4164743152799650707_n](https://user-images.githubusercontent.com/53705624/173233958-282f141b-6fb4-4bda-8c3f-4907c0387b1f.jpg)

