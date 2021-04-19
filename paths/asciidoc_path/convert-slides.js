var asciidoctor = require('@asciidoctor/core')()
var asciidoctorRevealjs = require('@asciidoctor/reveal.js')
asciidoctorRevealjs.register()

var options = { safe: 'safe', backend: 'revealjs' }
asciidoctor.convertFile('slide_1.adoc', options)