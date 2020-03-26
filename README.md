# NeuCheck
A More Practical Ethereum Smart Contract Security Analysis Tool

We implement NeuCheck in Java, which employs ANTLR, a powerful parser generator, to complete intermediate representation transformation, and then uses dom4j to parse intermediate representation. 

## Solidity parser
NeuCheck uses the Solidity parser built by ANTLR to transform the smart contract source code into an XML parse tree, an intermediate representation. ANTLR is a powerful parser generator for reading, processing, or translating structured languages or binary files. It is widely used to build languages, tools, and frameworks because of its parsing capabilities keeping the flexibility and simplicity. The ANTLR parser could identify the valid input, regardless of its complexity, and construct a parse tree more easily traversable. We use its lexer to identify source code and convert it into discrete groups of characters called tokens, including keywords, identifiers, symbols and operators. Then,the parser organizes these tokens and transforms them into a valid sequence, such as a syntax tree, according to the given grammar.

## Core detector
NeuCheck uses Core detector implemented by dom4j to analyze the vulnerabilities. As an upgrade product of JDOM, dom4j makes immense improvements in the areas of flexibility, ease of use, and performance. For instance, it can easily process XML, XPath, and XSLT on the Java platform, and fully support DOM, SAX and JAXP. 

## How to cite
Lu N, Wang B, Zhang Y, Shi W, Esposito C. NeuCheck: A more practical Ethereum smart contract security analysis tool. Softw: Pract Exper. 2019;1–20. https://doi.org/10.1002/spe.2745
