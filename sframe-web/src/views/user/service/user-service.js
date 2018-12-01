import axios from "../../../axios/axios";

export function getUserDetail (_userId) {
  return axios.post('/api/sys/user/getUserDetail.do',{userId: _userId});
}

export default {
  getUserDetail
}
