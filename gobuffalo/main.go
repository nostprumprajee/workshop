package main

import "net/http"

func handler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("content-type", "application/json")
	w.Write([]byte(`{"message": "hello world"}`))
}

func main() {
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8001", nil)
}