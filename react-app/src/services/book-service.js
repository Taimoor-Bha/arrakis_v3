import http from './axios-common';

export function getAllBooks(){
    return http.get("/books");
}