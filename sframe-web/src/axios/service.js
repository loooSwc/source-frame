import axios from "axios";


export function tablePage (url,params,pageNum,pageSize) {
  let pageParams = {
    pageSize: pageSize?pageSize:10,
    pageNumber: pageNum?pageNum:1,
    params: params
  }
  return new Promise((resolve,reject) => {
    axios.post(url,pageParams)
      .then(response => {
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}

export default {
  tablePage
}
