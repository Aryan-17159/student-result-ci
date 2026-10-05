# Student Result Management - Unit III CI assignment

This project uses Java 17, Maven, JUnit 5 and GitHub Actions. It performs CI only.
The three operations calculate total marks, calculate the average, and determine
whether a student passed every subject. Each subject is out of 100; the minimum
passing mark is 40 per subject. These are project rules, not university policy.

## 1. Use a Linux terminal

Use your college Linux machine, an Ubuntu virtual machine, or Ubuntu in WSL on
Windows. Git Bash is not a Linux environment. If Ubuntu is not yet available,
ask for setup guidance before continuing.

Extract the ZIP. Open a Linux terminal inside the extracted `student-result-ci`
folder (the directory containing `pom.xml`). On WSL, Windows drive C is available
at `/mnt/c`; use `cd` followed by your actual extracted project path in quotes.

For Ubuntu, install the tools if needed:

```bash
sudo apt update
sudo apt install -y openjdk-17-jdk maven git tree
java -version
javac -version
mvn -version
git --version
```

Maven must use Java 17 or later. Internet access is needed to fetch dependencies
on the first build. Run all subsequent commands from the project folder.

## 2. Inspect and understand the source files

```bash
pwd
tree -a -I 'target|.git'
cat src/main/java/com/example/results/StudentResult.java
cat src/test/java/com/example/results/StudentResultTest.java
cat pom.xml
cat .github/workflows/ci.yml
```

Use an editor with readable font size for the source-code screenshots; take
multiple screenshots if needed. The report also requires the full code as text.

## 3. Build and test locally

```bash
mvn --batch-mode --no-transfer-progress clean verify
```

Expected output after a successful run (this is a target, not a captured result):

```text
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

If the build fails, resolve it before pushing. Save screenshots showing the
command, test summary, and BUILD SUCCESS. Actual test reports appear in
`target/surefire-reports/`.

Run the sample application after the build:

```bash
java -cp target/classes com.example.results.StudentResult
```

Expected sample result: total 245, average 81.67, PASS.

## 4. Initialize Git and commit

Replace the name and email below with your details; you may use your GitHub
privacy email. These settings apply only to this project.

```bash
git init
git config user.name "YOUR NAME"
git config user.email "YOUR GITHUB EMAIL"
git add .
git commit -m "Add student result application, JUnit tests and CI workflow"
git branch -M main
git log -1 --oneline
git status
```

Capture the initialization and commit output. Do not commit `target/`.

## 5. Create a GitHub repository and push

Sign in to GitHub and create a repository called `student-result-ci`. Choose
visibility according to your course requirements and make sure your instructor
can access it. Leave automatic README, license and .gitignore creation unchecked
so the remote starts empty. Do not upload the ZIP itself to the repository.

Replace YOUR_USERNAME in this command with your actual GitHub username:

```bash
git remote add origin https://github.com/YOUR_USERNAME/student-result-ci.git
git push -u origin main
```

Use GitHub's supported authentication if prompted; an account password does not
work for HTTPS Git pushes. Never include tokens or passwords in screenshots.

The GitHub Code page should show `src`, `pom.xml`, `.github/workflows/ci.yml`,
README.md and .gitignore. Screenshot this page with the repository URL visible.

## 6. Verify GitHub Actions

Open the repository's Actions tab, then the `Java Maven CI` run for your pushed
commit. Open `build-and-test` and expand `Build and run JUnit tests`.

Confirm that the actual log contains all 10 passing tests and BUILD SUCCESS,
and that the run concludes successfully. Capture the run overview and expanded
logs. Do not assume a green result until the workflow finishes.

To demonstrate another push-triggered run, make a small meaningful README edit:

```bash
git add README.md
git commit -m "Document local verification"
git push
```

## 7. Collect every required screenshot

| No. | Evidence |
| --- | --- |
| 01 | Project structure, including src and .github/workflows |
| 02 | Java source code |
| 03 | JUnit test code |
| 04 | pom.xml |
| 05 | Linux terminal showing the Maven command and execution |
| 06 | Local test summary and BUILD SUCCESS |
| 07 | Git initialization and commit output |
| 08 | GitHub repository containing the project and visible URL |
| 09 | GitHub Actions YAML workflow |
| 10 | Actual Actions workflow execution and steps |
| 11 | Successful CI run overview |
| 12 | Expanded Actions logs showing the automated test summary |

Screenshots must come from your own implementation. Use readable, uncropped
evidence of the relevant commands/pages. Several images may be needed for long
files. Keep screenshots outside this repository if they contain personal details.

## 8. Finish the report

`REPORT_DRAFT.md` includes the 14 required sections, full source files, a CI
diagram definition, and suggested short answers to understand and rewrite in
your own words. It is a draft, not a completed submission. Replace every bracketed
placeholder, include your actual repository URL and screenshots, and export
one PDF. Send the screenshots, repository URL, name, USN and section to the
assistant if you want help assembling and checking the final PDF.

## Verification status of the supplied package

The files have been prepared but have not been compiled or tested in the
assistant environment, which lacks Maven and the Java compiler. A GitHub Actions
run has not been performed. Complete the required local and remote runs above.

## Official reference

https://docs.github.com/en/actions/tutorials/build-and-test-code/java-with-maven

Action versions follow the official action repositories:
https://github.com/actions/checkout and https://github.com/actions/setup-java
