import axios from "axios";

export default class BookService{

    getAll(){
        return axios.get("http://localhost:8080/api/books/getall")
    }

    findById(id){
        return axios.get("http://localhost:8080/api/books/findById?id="+id)
    }
   
    getByCategory(id){
        return axios.get("http://localhost:8080/api/books/getByCategory?categoryId="+id)
    }
    getAllSortedByPage(){
        return axios.get("http://localhost:8080/api/books/getAllSorted")
    }
    add(values){
        return axios.post("http://localhost:8080/api/books/add",values)
    }
}