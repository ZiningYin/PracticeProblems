package leet.Interfaces;

public interface IJumpGameVII1871
{
	// todo unit tests
	// Test cases
	// 1. cannot reach end because end is 1
	// 2. cannot reach because end is too far away from last reachable point
	// 3. cannot reach because end is too close to last reachable point
	// 4. reaches end
	boolean canReach(String s, int minJump, int maxJump);
}
