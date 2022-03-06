package main

import (
	"log"

	"github.com/nashmaniac/leetcode/golang"
)

func main() {
	testString := []string{
		"abc",
		"aaa",
		"aabbbaa",
	}

	for _, i := range testString {
		log.Println(i, golang.CountSubstrings(i))
	}
}
