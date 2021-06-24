# Mobile Assignment CS
I have developed an app that is responsible for interacting with the TMDB API.
In this application it mainly consists of two sections.

1. **Now Playing.**
	* Displays a horizontal list of movies currently playing
2. **Popular Movies**
	* Displays a vertical list of the most popular movies.

**Higlights**
	* In the list of popular movies, a paging mechanism is implemented that retrieves more movies as the user scrolls down, giving a very smooth effect, it is almost imperceptible to the user that data from the web is being consulted.
	* In either of the two lists mentioned, you can tap to see the detail of the selected movie.
	* The application only runs in portrait mode, it does not accept screen rotation

## Technologies and plugins
**Programming language**
	* The complete project is developed in Java.
	
**Plugins and components**
Common Google libraries are used, the most remarkable thing is that the lists are implemented with RecyclerView, to give it a modern and optimized interface.
The API consumption was implemented with the help of the Volley library
I used the Picasso library to manage thumbnails and cache images, it is astonishing.

**Complete list of libraries added manually**
	* androidx.coordinatorlayout: coordinatorlayout: 1.1.0
	* com.google.android.material: material: 1.3.0
	* com.android.volley: dc-volley: 1.1.0
	* com.squareup.picasso: picasso: 2.71828
	* net.danlew: android.joda: 2.10.6

## Custom components
I have developed my own visual component for the visualization of a Pie Chart with the rating of each movie.
In this project the component is inside the main project however, for a productive development I usually encapsulate the own components in an independent library (Generally called customUI) or something like that.

## Screenshots UI/UX
You can find some Screenshots in the folder where the present file is located.

## Issues
	* I have found that the JSON that TMDB responds in the requests provided for the assignment, for such a situation I have omitted to display that information.
	* The colors of the interface may vary from the provided mockup, even when they were obtained using the tool: https://imagecolorpicker.com/
	* I added a progressbar on top of the activity that is displayed discreetly when querying the API.
	
	
### Additional Comments
Thank you for the opportunity to present this assignment, I look forward to working together soon.
Cheers!
