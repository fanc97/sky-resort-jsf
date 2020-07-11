const DOMtrack=document.getElementById("tracks");
const DOMweather=document.getElementById("weather");
const DOMskiResort=document.getElementById("ski-pass");
const eventTrack=document.getElementById('cTracks');
const eventWeather=document.getElementById('cWeather');
const eventSkyPass=document.getElementById('cSkiPass');

document.addEventListener('DOMContentLoaded', () => {
	eventTrack.classList.add('active');            
    DOMtrack.classList.add('displayTrue');
});


	eventTrack.addEventListener("click",()=>{
			eventTrack.classList.add('active');    
			eventWeather.classList.remove('active');    
			eventSkyPass.classList.remove('active');    
			DOMtrack.classList.add('displayTrue');
			DOMweather.classList.remove('displayTrue');
			DOMskiResort.classList.remove('displayTrue');	  
	});
  eventWeather.addEventListener('click',()=>{

		eventTrack.classList.remove('active');    
		eventWeather.classList.add('active');    
		eventSkyPass.classList.remove('active');    
		DOMtrack.classList.remove('displayTrue');
		DOMweather.classList.add('displayTrue');
		DOMskiResort.classList.remove('displayTrue');
  });
  eventSkyPass.addEventListener('click',()=>{
		eventTrack.classList.remove('active');    
		eventWeather.classList.remove('active');    
		eventSkyPass.classList.add('active');    
		DOMtrack.classList.remove('displayTrue');
		DOMweather.classList.remove('displayTrue');
		DOMskiResort.classList.add('displayTrue');
  });
  