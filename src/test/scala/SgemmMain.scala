// See README.md for license details.

package sgemm

import chisel3._

/**
  * This provides an alternate way to run tests, by executing then as a main
  * From sbt (Note: the test: prefix is because this main is under the test package hierarchy):
  * {{{
  * test:runMain sgemm.SgemmMain
  * }}}
  * To see all command line options use:
  * {{{
  * test:runMain sgemm.SgemmMain --help
  * }}}
  * To run with verilator:
  * {{{
  * test:runMain sgemm.SgemmMain --backend-name verilator
  * }}}
  * To run with verilator from your terminal shell use:
  * {{{
  * sbt 'test:runMain sgemm.SgemmMain --backend-name verilator'
  * }}}
  */
object SgemmMain extends App {
  iotesters.Driver.execute(args, () => new Sgemm) {
    c => new SgemmUnitTester(c)
  }
}

/**
  * This provides a way to run the firrtl-interpreter REPL (or shell)
  * on the lowered firrtl generated by your circuit. You will be placed
  * in an interactive shell. This can be very helpful as a debugging
  * technique. Type help to see a list of commands.
  *
  * To run from sbt
  * {{{
  * test:runMain sgemm.SgemmRepl
  * }}}
  * To run from sbt and see the half a zillion options try
  * {{{
  * test:runMain sgemm.SgemmRepl --help
  * }}}
  */
object SgemmRepl extends App {
  iotesters.Driver.executeFirrtlRepl(args, () => new Sgemm)
}