
# serialization #

This project serializes objects to a pseudo-XML format and deserializes them from this format back into objects using reflection. It was my submission for an assignment in CS 442: Design Patterns at Binghamton University in fall 2017. For more details, see the assignment document.

## Instructions ##

To compile:

    ant -buildfile genericCheckpointing/src/build.xml all

-------------------------------------------------------------------------------

To run:

    ant -buildfile genericCheckpointing/src/build.xml run -Darg0=serdeser -Darg1=5 -Darg2=file.txt

-------------------------------------------------------------------------------

To clean:

    ant -buildfile genericCheckpointing/src/build.xml clean

