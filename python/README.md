Tic Tac Toe
===========

Graphical version of tic-tac-toe using [pygame](https://www.pygame.org/news).

## Suggested System Requirements

* virtualenv

## Installation

As with any Python package, there are many ways to install and run tic tac toe.
This is one suggestion using virtual environments.

```bash
git clone https://github.com/pegeler/tic-tac-toe.git
cd tic-tac-toe/python
virtualenv venv
venv/bin/python setup.py install
```

## To play

If you installed with the code above, run the game with this command:

```bash
venv/bin/ttt
```

You can specify player names in the command line too:

```bash
venv/bin/ttt bob sue
```

## Bots

You may play against a bot by specifying `computer` as one of the player names
in the command line.

```bash
venv/bin/ttt bill computer
```

## In-game controls

* Choose a square by clicking on it.
* Reset board with the <kbd>R</kbd> key.
* Exit the game with the <kbd>Esc</kbd> key.
