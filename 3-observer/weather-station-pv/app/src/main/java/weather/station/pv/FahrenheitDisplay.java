package weather.station.pv;
public class FahrenheitDisplay implements Observer, DisplayElement{
    float fahrenTemp;
    WeatherData weatherData;
    public FahrenheitDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
    }

    //Solo necesita temp
    @Override
    public void update(){
        float temp = weatherData.getTemperature();

        fahrenTemp = temp * 9;
        fahrenTemp = fahrenTemp / 5;
        fahrenTemp = fahrenTemp + 32; 
        display();
    }

    @Override
    public void display(){
        System.out.println("La temperatura se ha actualizado, en fahrenheit es: " + fahrenTemp);
    }
}
