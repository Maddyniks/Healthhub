let locationName;
window.addEventListener("load", () => {
    locationName = document.querySelector(".location-name");
    
});


const getGeoLocation = () => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        long = position.coords.longitude;
        lat = position.coords.latitude;
        console.log("Lat: " + lat + "Lon: " + long);
        const url = `${proxy}http://api.weatherstack.com/current?access_key=${key}&query=${lat},${long}&hourly=1`;
        callAPI(url);
      });
    }
  };
  getGeoLocation();

  const key = "7834fd4e3be2f0300356603b771ee2db";
  const proxy= "https://cors-anywhere.herokuapp.com/";

  const callAPI = (api) => {
    console.log("callAPI clicked.");
    fetch(api)
      .then((response) => {
        return response.json();
      })
      .then((data) => {

        const { name, region, localtime, timezone_id } = data.location;
        console.log("Address = " + name);
        locationName.textContent = name + ", " + region;

      })
      .catch((err) => {
        console.log(`Error| ${err}`);
      });
  };