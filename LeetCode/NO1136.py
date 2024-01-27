class Solution(object):
    def minimumSemesters(self, n, relations):
        ans = 0
        courses = dict()
        taken = []
        for x in range(1, n + 1):
            courses.update({x: []})
        print(courses)

        for relation in relations:
            courses[relation[1]].append(relation[0])
        print(courses)

        class_took = True
        while courses and class_took:
            class_took = False
            semester = []
            keys = list(courses.keys())
            for course in keys:
                can_take = True
                for prerequisite in courses.get(course):
                    if prerequisite not in taken:
                        can_take = False
                        break
                if can_take:
                    semester.append(course)
                    class_took = True
                    courses.pop(course)

            taken.extend(semester)
            ans += 1

        print(courses)
        return ans
        
solver = Solution()
print(solver.minimumSemesters(3, [[1, 2], [2, 3], [1, 3]]))
