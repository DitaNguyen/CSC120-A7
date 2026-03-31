Use this file to record your reflection on this assignment.

- What are your initial impressions of how `Inheritance` affects your programming?
Inheritance makes my code feel much more professional. Instead of copy-pasting basic attributes like name and address into every file, I can define them once in Building.java and let the subclasses focus on their unique logic. It forces me to think about my program as a cohesive system rather than just a collection of disconnected files.

- What worked, what didn't, what advice would you give someone taking this course in the future?
What worked was using super() to handle common constructor logic. Leveraging the built-in methods for ArrayList and Hashtable also made managing residents and book collections much easier than I expected.

I struggled with "Type Mismatch" errors early on. I tried using String for names when the HouseRequirements interface strictly demanded Student objects. Learning that Java treats these as entirely different types was a big "aha" moment.

My advice for future students would be sketch a quick "family tree" of your classes before coding to see what should be shared and what should be unique. Also, writing the /** ... */ headers while the logic is fresh in your mind is way easier than doing it all at the end.
