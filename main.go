package main

import (
	"log"

	"github.com/nashmaniac/leetcode/golang"
)

func main() {
	testString := []string{
		"abdbca",
		"cddpd",
		"pqr",
		"pp",
	}

	for _, i := range testString {
		log.Println(golang.LongestPalindromeSubseq(i))
	}
}
