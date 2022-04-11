## Change your name here:
MYNAME=RomainSERPOLLET

## DO NOT change below
SRC=Restaurant
HERE=$(PWD)
MAINCLASS=TestRestaurant
SRCJAVA=$(wildcard $(SRC)/*.java)
CLASSFILES = $(SRCJAVA:.java=.class)

all:clean run

# Compile
%.class: %.java
	javac $^

# Run
run: $(SRC)/$(MAINCLASS).class
	java $(SRC)/$(MAINCLASS)

tar: clean
	dir=$$(basename $$PWD/$$SRC) && cd .. && \
	tar cvfz "TP03-$(MYNAME).tgz" --exclude=".git" "$$dir"

clean:
	rm -f $(SRC)/*.class $(SRC)/*~ *~
