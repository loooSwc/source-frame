import axios from "../../../axios/axios";

export function getRoleList (_userId) {
  return axios.post('/api/sys/role/getRoleList.do',{userId: _userId});
}

export default {
  getRoleList
}
