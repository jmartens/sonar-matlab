#!/bin/bash

TEMPFILE=$TMP/$(basename $0).$$.tmp
FILE=./rules.xml
PROFILE=../profile-default.xml

# Dump rules
/c/Program\ Files/MATLAB/R2014b/bin/win64/mlint -allmsg 2> $TEMPFILE

# Transform to rules.xml
echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > $FILE 
echo "<rules>" >> $FILE 
cat $TEMPFILE \
| sed -e '/^.*\=.*$/d' -e 's/^\s*//' -e 's/ \{2,\}/|/g' \
| awk -F "|" '{ print "\t<rule>\n\t\t<key>"$1"</key>\n\t\t<configKey>"$1"</configKey>\n\t\t<name>"$1"</name>\n\t\t<priority>"$2"</priority>\n\t\t<description>\n\t\t\t<![CDATA["$3"]]>\n\t\t</description>\n\t</rule>"; }' >> $FILE
echo "</rules>" >> $FILE
sed -i 's/>7</>BLOCKER</' $FILE
sed -i 's/>5</>BLOCKER</' $FILE
sed -i 's/>4</>CRITICAL</' $FILE
sed -i 's/>3</>MAJOR</' $FILE
sed -i 's/>2</>MINOR</' $FILE
sed -i 's/>1</>INFO</' $FILE
sed -i 's/>0</>INFO</' $FILE

# Create rules-profile.xml
echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > $PROFILE 
echo "<profile>" >> $PROFILE
echo "	<name>Sonar way</name>" >> $PROFILE
echo "	<language>matlab</language>" >> $PROFILE
echo "	<rules>" >> $PROFILE 
cat $TEMPFILE \
| sed -e '/^.*\=.*$/d' -e 's/^\s*//' -e 's/ \{2,\}/|/g' \
| awk -F "|" '{ print "\t\t<rule>\n\t\t\t<repository>MLint<repository>\n\t\t\t<key>"$1"</key>\n\t\t\t<priority>"$2"</priority>\n\t\t</rule>"; }' >> $PROFILE
echo "	</rules>" >> $PROFILE
echo "</profile>" >> $PROFILE
sed -i 's/>7</>BLOCKER</' $PROFILE
sed -i 's/>5</>BLOCKER</' $PROFILE
sed -i 's/>4</>CRITICAL</' $PROFILE
sed -i 's/>3</>MAJOR</' $PROFILE
sed -i 's/>2</>MINOR</' $PROFILE
sed -i 's/>1</>INFO</' $PROFILE
sed -i 's/>0</>INFO</' $PROFILE

rm -f $TEMPFILE