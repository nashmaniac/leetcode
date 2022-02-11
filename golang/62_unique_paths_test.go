package golang_test

import (
	"github.com/nashmaniac/leetcode/golang"
	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
)

var _ = Describe("UniquePaths", func() {

	Context("when the data is valid", func() {
		It("passes", func() {
			result := golang.UniquePaths(3, 7)
			Expect(result).To(Equal(28))
		})
	})
})
