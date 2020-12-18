package cn.edu.bjtu.devicesimulate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Component
@Order(1)
public class Init implements ApplicationRunner {

    @Value("${edge.ip}")
    private String ip;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int[] speed = new int[]{106,28,22,36,98,90,33,92,13,49,52,102,12,62,60,38,78,11,61,80,104,72,101,26,28,14,58,47,46,81,75,65,25,87,67,33,63,57,60,78};
        int[] mileage = new int[]{20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98};
        int[] rotation = new int[]{1732,1854,526,2081,1470,2383,1181,838,1726,2261,549,1990,2236,2261,2198,764,1322,1356,1807,1148,1721,846,2054,548,1203,917,2487,629,709,2405,1936,1278,2333,1499,2068,2491,2384,1580,1214,960};
        int[] midOil = new int[]{135,132,129,126,123,120,117,114,111,108,105,102,99,96,93,90,87,84,81,78,75,72,69,66,63,60,57,54,51,48,45,42,39,36,33,30,27,24,21,18};
        int[] temperature = new int[]{20,58,80,82,65,85,27,26,74,28,21,33,64,18,49,47,58,43,39,32,17,16,33,39,81,22,35,69,31,56,41,37,80,66,81,62,54,22,75,27};
        int[] oilTemperature = new int[]{51,93,108,75,105,59,35,47,82,36,96,122,99,60,114,27,92,65,32,55,115,98,68,58,28,56,45,114,67,49,40,72,69,120,95,76,26,123,92,92};
        int[] firstOil = new int[]{270,264,258,252,246,240,234,228,222,216,210,204,198,192,186,180,174,168,162,156,150,144,138,132,126,120,114,108,102,96,90,84,78,72,66,60,54,48,42,36};
        String url = "http://" +ip+ ":8095/api/perception/exportSimulate/装甲兵1旅/08式步战车/08式步战车-1-1";
        int i = 0;
        while (true){
            MultiValueMap<String, Integer> js = new LinkedMultiValueMap<>();
            js.add("speed",speed[i]);
            js.add("mileage",mileage[i]);
            js.add("rotation",rotation[i]);
            js.add("midOil",midOil[i]);
            js.add("temperature",temperature[i]);
            js.add("oilTemperature",oilTemperature[i]);
            js.add("firstOil",firstOil[i]);
            try {
                restTemplate.postForObject(url,js,String.class);
            }catch (Exception ignored){
            }
            if (i>=39){
                i=0;
                break;
            }
            i++;
            Thread.sleep(3000);
        }
    }
}
