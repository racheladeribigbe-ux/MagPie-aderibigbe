# Magpie

A chatbot that carries on a conversation by looking for words it recognises.

Magpie is not clever and is not supposed to be. It is a pile of `if` statements
reading strings — which is exactly what Unit 1 and Unit 2 are about, and it is
the first thing you will write that somebody else can *use* rather than just
run.

## Start here

1. Open the folder in **VS Code**. `src/` holds the code; `bin/` is where the
   compiled classes land and is gitignored.
2. Run **`MagpieRunner.java`** — that is the file with `main`. You should get a
   placeholder greeting, and anything you type echoes back.
3. Type `Bye` to stop it.
4. That is the whole loop: change something, run it, talk to it. Commit as you
   go, and **send your teacher the link to your repository** — pushing saves
   your work, the link is what hands it in.

Everything in `Magpie.java` that is yours currently returns a `PLACEHOLDER`.
That is on purpose — none of it is written yet, and the TODOs are the
assignment.

## What you are given, and what you write

| Provided | Yours |
| --- | --- |
| `findKeyword(statement, goal)` and its three-argument overload | Deciding which keywords are worth searching for |
| `MagpieRunner.java` — a `Scanner` loop that runs until you type `Bye` | Nothing. Read it, though: it is a real sentinel loop |
| Method signatures for `getGreeting`, `getResponse` and `getRandomResponse` | Every one of their bodies |

## The milestones

Do them in order and run after each one. Each milestone is a working chatbot,
which is what makes this lab pleasant instead of frightening.

| Milestone | What you write | CED |
|---|---|---|
| 1 | `getGreeting()` — your chatbot's own voice, and one keyword branch | `1.15.A`, `3.5.A` |
| 2 | `getResponse()` searching with `indexOf` | `1.15.B`, `2.2.A`, `2.5.A` |
| 3 | The same searches through the provided `findKeyword` | `2.3.A`, `2.10.A` |
| 4 | Several related words per branch, joined with `\|\|` | `2.3.A`, `2.5.A` |

### Milestone 1 — make it yours

One method, one string, then one branch in `getResponse` that answers a single
keyword. The point is to prove the project runs before anything is at stake.

### Milestone 2 — search with `indexOf`

`String.indexOf` returns the position of what you asked for, or `-1` if it is
not there. So this is the Boolean expression for "the word is in there":

```java
statement.indexOf("dog") >= 0
```

Note the `>= 0` and not `> 0` — index 0 is a real position, and a keyword at
the very start of a sentence is silently ignored if you get this backwards.

Two decisions worth a comment saying what you chose:

- **How you search.** `>= 0` or `!= -1`. Both work. Pick one and be consistent.
- **Order.** The first matching branch wins, so your `if` / `else if` order is a
  decision about which topic matters most. A general keyword placed above a
  specific one will swallow it.

Also handle the empty statement — the user pressing Enter with nothing typed is
a real case and it should not fall through to a keyword branch.

### Milestone 3 — why `"mother"` matches `"grandmother"`

Because `indexOf` finds *substrings*, and `grandmother` contains `mother`. Run
into it deliberately. Then read the provided `findKeyword` and see how it fixes
the problem: it checks the character on each side of the hit and only accepts
the match when neither is a letter. That is why `"I know"` does not trigger a
`"no"` rule.

Move your searches over to it. You do not write it and you should not change it.

### Milestone 4 — several words, one branch

One branch answering several related words with `||`. `findKeyword` already
lowercases both sides, so `Mother` and `mother` are the same word once you are
calling it — read it before you write your own case handling.

### The fallback

When nothing matches, say something non-committal — and not the *same*
non-committal thing every time. `getRandomResponse()` is where that lives.
`Math.random()` gives a `double` in `[0.0, 1.0)`; turning that into a whole
number in range is a multiply and a cast, and getting the range right at both
ends is the exercise.

**Every input has to get an answer.** If every rule is an `if` with no trailing
`else`, some inputs get an empty reply.

## How it is graded

| | Weight |
| --- | --- |
| At least six distinct keyword rules, each responding sensibly | 40% |
| Whole-word matching, so `"mother"` does not fire on `"grandmother"` | 20% |
| Case-insensitive, and a fallback branch that always answers | 20% |
| Readable: meaningful names, no branch unreachable, commented where it is not obvious | 20% |

## Check your own work before you hand it in

- [ ] Every `PLACEHOLDER` is gone. Search the file for it.
- [ ] `YOUR NAME HERE` at the top of `Magpie.java` is your name.
- [ ] Every TODO comment is either done and deleted, or still there because you
      genuinely have not done it — not left behind above finished code.
- [ ] At least six keyword rules.
- [ ] An empty statement gets its own sensible reply.
- [ ] The fallback response varies between runs.
- [ ] String comparisons use `.equals()`, not `==`.
- [ ] The whole conversation works end to end, and `Bye` exits cleanly.
- [ ] It compiles from a fresh clone — no absolute paths to your own disk.
- [ ] Your commit messages say what changed, it is **pushed**, and your teacher
      has the link.

## If you finish early

None of these are required, and each one is a real design problem rather than
more of the same:

- **Make it remember.** A field holding the last thing the user said lets you
  answer *"you mentioned your brother earlier"* — one line of state away from
  everything Unit 3 is about. Watch out for `==` on strings; use `.equals()`.
- Respond to a *question* differently from a statement.
- Recognise a topic across several words in one sentence, not just the first
  match.

## Credits

The Magpie Lab — the class, its method signatures, `findKeyword`, and the idea —
is by **Laurie White**, April 2012, written for AP Computer Science A. This
repository is a skeleton of that lab for classroom use; the implementations are
the student's.

Learning objective codes reference the College Board *AP Computer Science A
Course and Exam Description* (effective Fall 2025).

