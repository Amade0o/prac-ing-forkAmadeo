import org.junit.jupiter.api.Test;

public class TestObservers {

    @Test
    public void testThreeObservers() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }

    //Tests con los displays provistos
    @Test
    public void testStatisticsDisplay(){
        //Creo sujeto
        WeatherData weatherData = new WeatherData();
        
        //Creo observer
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        //Registro el observer
        weatherData.registerObserver(statisticsDisplay);
    
        //Cargo valores (que luego se le notificaran al observer)
        weatherData.setMeasurements(80,65,40.4f);
        //En teoria sujeto ejecutó el notify() que ejecuta el update() del observer
        //Asique en teoria se ejecutó el display...

        //Cargo valores nuevos para que actualice el minimo
        weatherData.setMeasurements(73,65,40.4f);

        //El minimo deberia ser 73
        weatherData.setMeasurements(90,65,40.4f);
    }

    @Test
    public void forecastDisplayTest(){
        //Creo sujeto
        WeatherData weatherData = new WeatherData();
        
        //Creo observer
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        //Registro el observer
        weatherData.registerObserver(forecastDisplay);
    
        //Cargo valores (que luego se le notificaran al observer)
        weatherData.setMeasurements( 80,65,30.4f);
        //En teoria sujeto ejecutó el notify() que ejecuta el update() del observer
        //Asique en teoria se ejecutó el display...

        //Cargo los mismos valores para que diga que es lo mismo
        weatherData.setMeasurements( 80,65,30.4f);

        //Incremento la presion para que diga que mejora
        weatherData.setMeasurements( 80,65,31.4f);

        //Disminuyo la presion para que diga que empeora
        weatherData.setMeasurements( 80,65,29.4f);
    }

    @Test
    public void currentConditionsDisplayTest(){
        //Creo sujeto
        WeatherData weatherData = new WeatherData();

        //Creo observer
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        //Registro el observer
        weatherData.registerObserver(currentConditionsDisplay);

        //Cargo valores (que luego se le notificaran al observer)
        weatherData.setMeasurements( 80,65,30.4f);
        //En teoria sujeto ejecutó el notify() que ejecuta el update() del observer
        //Asique en teoria se ejecutó el display...

        //Cargo valores nuevos para que los muestre el observer
        weatherData.setMeasurements( 82,70,29.2f);
    }

    @Test
    public void switchingObserversTest(){
        WeatherData weatherData = new WeatherData();

        //Creo el observer
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        //Lo registro
        weatherData.registerObserver(statisticsDisplay);
        //Cargo valores
        weatherData.setMeasurements( 80,65,30.4f);

        //Deberia haber mostrado las estadisticas con un solo valor
        weatherData.removeObserver(statisticsDisplay);

        //Creo otro observer
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        //Lo registro
        weatherData.registerObserver(forecastDisplay);
        //Cargo nuevos valores
        weatherData.setMeasurements( 82,70,29.2f);

        //Deberia haber mostrado el pronostico con los valores cargados
        weatherData.removeObserver(forecastDisplay);

        //Creo otro observer
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        //Lo registro
        weatherData.registerObserver(currentConditionsDisplay);
        //Cargo nuevos valores
        weatherData.setMeasurements( 78,90,29.2f);

        //Deberia haber mostrado las condiciones actuales con los valores cargados
    }

    @Test
    public void allObserversTest(){
        WeatherData weatherData = new WeatherData();

        //Creo los observers
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        //Los registro
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);
        weatherData.registerObserver(currentConditionsDisplay);

        //Cargo valores
        weatherData.setMeasurements( 80,65,30.4f);
        weatherData.setMeasurements( 82,70,29.2f);
        weatherData.setMeasurements( 78,90,29.2f);

        //Deberia haber mostrado las estadisticas, el pronostico y las condiciones actuales con los valores cargados
    }

    @Test
    public void FahrenheitDisplayTest(){
        WeatherData weatherData = new WeatherData();

        //Crear observer
        FahrenheitDisplay fahrenheitDisplay = new FahrenheitDisplay(weatherData);

        //Seteo el observer en weatherData
        weatherData.registerObserver(fahrenheitDisplay);

        //Seteo valores en el weather
        weatherData.setMeasurements(80,65,27.9f);
    }

    @Test
    public void WindChillDisplayTest(){
        WeatherData weatherData = new WeatherData();

        //Crear observer
        WindChillDisplay windChillDisplay = new WindChillDisplay(weatherData);

        //Seteo el observer en weatherData
        weatherData.registerObserver(windChillDisplay);

        //Cargo valores en weatherData, se imprimirán solos
        weatherData.setMeasurements(80,65,27.9f);
    }
}
