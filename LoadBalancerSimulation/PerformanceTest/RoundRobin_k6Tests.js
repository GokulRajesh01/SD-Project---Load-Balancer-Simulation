// K6 - Performance Test upcoming in this Space
import { sleep } from 'k6';
import http from 'k6/http';

export const options = {
    stages: [
        { duration: '30s', target: 2000}, // ramp-up
        { duration: '2m', target: 2000}, // stable 
        { duration: '30s' , target: 0} // ramp-down
    ],
    thresholds: {
        http_req_duration: ['p(99)<100'], // 99% of request must be completed
    }
};

export default () => {
    http.get('http://localhost:8080/api/v1/sayHello');
    sleep(1);
}