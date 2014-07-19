package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

	trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
		/**
		 * This method applies a list of moves `ls` to the block at position
		 * `startPos`. This can be used to verify if a certain list of moves
		 * is a valid solution, i.e. leads to the goal.
		 */
		def solve(ls: List[Move]): Block =
			ls.foldLeft(startBlock) {
				case (block, move) => move match {
					case Left => block.left
					case Right => block.right
					case Up => block.up
					case Down => block.down
				}
			}
	}

	trait Level1 extends SolutionChecker {
		/* terrain for level 1*/

		val level =
			"""ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

		val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
	}

	test("terrain function level 1") {
		new Level1 {
			assert(terrain(Pos(0, 0)), "0,0")
			assert(!terrain(Pos(4, 11)), "4,11")
		}
	}

	test("findChar level 1") {
		new Level1 {
			assert(startPos == Pos(1, 1))
		}
	}

	test("done") {
		new Level1 {
			assert(done(Block(goal, goal)))
		}
	}

	test("neighborsWithHistory") {
		new Level1 {
			val expect = Set(
				(Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
				(Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up)))

			assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)).toSet === expect)

		}
	}

	test("new neighbors only") {
		new Level1 {
			val res = newNeighborsOnly(
				Set(
					(Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
					(Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream,
				Set(Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1))))

			val expected = Set((Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream

			assert(res == expected)
		}
	}

	test("optimal solution for level 1") {
		new Level1 {
			assert(solve(solution) == Block(goal, goal))
		}
	}

	test("optimal solution length for level 1") {
		new Level1 {
			assert(solution.length == optsolution.length)
		}
	}

	// Visualizer
	//EDIT: Missed copy/paste of this line
	trait Level1V extends Level1 with SolutionVisualizer {}

	trait SolutionVisualizer extends GameDef with Solver with StringParserTerrain {
		def clearScreen: Unit = print("\033[2J\033[1;1H")
		def cursorOff: Unit = print("\033[?25l")
		def cursorOn: Unit = print("\033[?25h")
		def printAt(x: Int, y: Int, c: Char): Unit = {
			print("\033[" + (x + 1) + ";" + (y + 1) + "H" + c)
		}

		def printBlock(b: Block, c: Char): Unit = {
			def clearAndPrintAt(p: Pos, c: Char): Unit = {
				if (c == '\000') printAt(p.x, p.y, vector(p.x)(p.y))
				else printAt(p.x, p.y, c)
			}

			if (!b.isStanding) {
				clearAndPrintAt(b.b1, c)
			}
			clearAndPrintAt(b.b2, c)
		}

		def displayBlock(b: Block): Unit = {
			printBlock(b, '#')
			Thread.sleep(1000)
			printBlock(b, '\000')
		}

		def displayTerrain(levelVector: Vector[Vector[Char]]): Unit = {
			for (i <- 0 to levelVector.size - 1; j <- 0 to levelVector(i).size - 1) {
				printAt(i, j, levelVector(i)(j))
			}
			println
		}

		def displaySolution(ls: List[Move]): Unit = {
			clearScreen
			cursorOff
			displayTerrain(vector)
			ls.foldLeft(startBlock) {
				case (block, move) => move match {
					case Left => { displayBlock(block); block.left }
					case Right => { displayBlock(block); block.right }
					case Up => { displayBlock(block); block.up }
					case Down => { displayBlock(block); block.down }
				}
			}
			displayTerrain(vector)
			cursorOn
		}

	}

	test("display solution Level1V") {
		new Level1V {
			displaySolution(solution)
		}
	}

	trait Level6V extends SolutionVisualizer {

		val level =
			"""-----oooooo
        |-----o--ooo
        |-----o--ooooo
        |Sooooo-----oooo
        |----ooo----ooTo
        |----ooo-----ooo
        |------o--oo
        |------ooooo
        |------ooooo
        |-------ooo""".stripMargin

		//    val optsolution = ...
	}

	test("display solution Level6") {
		new Level6V {
			displaySolution(solution)
			println(solution)
		}
	}
}

