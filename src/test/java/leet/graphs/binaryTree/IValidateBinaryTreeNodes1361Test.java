package leet.graphs.binaryTree;

import leet.AbstractTimedTest;
import leet.Interfaces.IValidateBinaryTreeNodes1361;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IValidateBinaryTreeNodes1361Test extends AbstractTimedTest<IValidateBinaryTreeNodes1361>
{
	@Test
	public void correctnessTest_ValidateBinaryTreeNodes()
	{
		correctnessTest(new ValidateBinaryTreeNodes());
	}

	@Test
	public void correctnessTest_ValidateBinaryTreeNodesOriginal()
	{
		correctnessTest(new ValidateBinaryTreeNodesOriginal());
	}

	public void correctnessTest(IValidateBinaryTreeNodes1361 solution)
	{
		assertTrue(solution.validateBinaryTreeNodes(5,new int[]{1,2,3,-1,-1}, new int[]{4,-1,-1,-1,-1}));
		assertTrue(solution.validateBinaryTreeNodes(5,new int[]{2,3,1,-1,-1}, new int[]{-1,-1,4,-1,-1}));

		assertFalse(solution.validateBinaryTreeNodes(5,new int[]{1,2,3,4,0}, new int[]{-1,-1,-1,-1,-1}));
		assertFalse(solution.validateBinaryTreeNodes(5,new int[]{1,2,3,-1,-1}, new int[]{4,-1,1,-1,-1}));
		assertFalse(solution.validateBinaryTreeNodes(5,new int[]{1,2,-1,-1,-1}, new int[]{4,-1,-1,-1,-1}));
		assertFalse(solution.validateBinaryTreeNodes(5,new int[]{1,2,-1,-1,-1}, new int[]{4,-1,-1,3,-1}));
		assertFalse(solution.validateBinaryTreeNodes(5,new int[]{1,2,3,-1,-1}, new int[]{0,-1,4,-1,-1}));
	}

	@RepeatedTest(10)
	public void loadTest_Compare()
	{
		int [] leftChildren1 = new int [] {1, 3, -1, 4, 5, -1, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 26, 28, 30, 32, -1, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, -1, 66, 68, 70, 72, 74, -1, 77, 78, 80, 82, 84, 86, -1, 89, 91, 92, 94, 96, -1, 99, 100, 102, 104, 105, 107, -1, 110, 111, 113, 115, 117, 119, 120, 122, 124, 126, 127, 129, 131, 133, 135, 136, 138, 140, 142, 144, 146, 148, 150, 152, -1, 155, 157, 159, -1, 162, 164, 166, 168, 170, 172, 174, 176, 178, 180, 182, 184, 186, 188, 190, 192, 194, 196, 198, 200, -1, 202, 204, 206, 208, 210, 212, -1, 215, 217, 219, 221, 223, 225, 227, 229, 231, 233, 235, 237, 239, 241, 242, 244, 245, 247, 249, 251, 253, 255, 257, -1, 259, 261, 263, 265, 267, 269, 270, 272, 274, 276, 278, 280, 282, 284, 285, 286, 288, 289, -1, 292, 293, 295, 297, 299, 301, 303, -1, 305, 307, -1, 310, 312, 314, 316, 317, 319, 321, 323, 325, 327, 329, 331, 333, 335, 337, 339, 341, 343, 345, 347, 349, 351, 353, 355, 357, 359, 361, 363, 365, 367, 369, -1, 372, -1, 375, -1, 377, 379, 381, 383, 385, 387, 389, 391, 392, 394, 396, 398, 400, 401, 403, 405, 407, 409, 411, 412, 414, 416, 418, 420, 422, 424, 426, 427, 429, 431, 433, 435, 436, 438, 440, -1, 443, 445, 446, 448, 449, 451, 453, -1, 456, 458, 460, 462, -1, 465, 467, 469, 471, 473, 475, 477, 479, 481, 483, 485, 487, 489, 490, 492, 494, 496, 498, 499, 500, 502, 504, 506, -1, 509, 511, 513, 515, 517, -1, 519, 521, 523, 525, 526, 528, 530, 532, 533, 535, 537, 539, 541, 543, 544, 546, 547, 549, 551, 553, 554, 556, 558, 560, 562, 564, -1, 567, 568, 570, 572, 573, 575, 577, 579, 581, 583, 585, -1, 588, 590, 592, 594, -1, 597, 598, -1, 601, 603, 605, -1, 608, 610, 611, 613, 615, 617, 619, 621, 623, 625, 627, 629, 631, 633, 634, 636, 638, 640, 642, 643, 645, 646, 648, 650, 652, 654, 656, 658, -1, 660, 662, 664, 666, -1, -1, 670, -1, 672, 674, 676, 678, 680, 682, 684, 686, 688, 690, 692, 694, 696, 698, 699, 701, 703, 705, 707, 709, 711, 713, 714, 716, 718, 720, 722, 724, 726, 728, 730, 732, 734, 736, 738, 740, 742, 744, 746, 748, 750, 752, 754, 756, 758, 760, 762, 764, -1, 767, 769, 771, 773, 775, 777, 779, 780, 782, -1, 785, 787, 788, 790, 792, 794, 796, 798, 800, 802, 804, 806, 808, 810, 812, 814, 816, 818, -1, 821, 823, 825, 827, 829, 831, 833, 834, 836, 838, -1, 841, 843, 845, 847, 848, 850, 852, 854, 856, 858, 860, -1, 863, 865, 867, 869, 871, 873, 874, 876, 878, 880, -1, 883, 885, 886, 888, 890, 892, 894, 896, 898, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int [] rightChildren1 = new int [] {2, -1, -1, -1, 6, 7, 9, 11, 13, -1, 16, 18, 20, 22, 24, -1, 27, 29, 31, -1, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63, 65, -1, 67, 69, 71, 73, 75, 76, -1, 79, 81, 83, 85, 87, 88, 90, -1, 93, 95, 97, 98, -1, 101, 103, -1, 106, 108, 109, -1, 112, 114, 116, 118, -1, 121, 123, 125, -1, 128, 130, 132, 134, -1, 137, 139, 141, 143, 145, 147, 149, 151, 153, 154, 156, 158, 160, 161, 163, 165, 167, 169, 171, 173, 175, 177, 179, 181, 183, 185, 187, 189, 191, 193, 195, 197, 199, -1, 201, 203, 205, 207, 209, 211, 213, 214, 216, 218, 220, 222, 224, 226, 228, 230, 232, 234, 236, 238, 240, -1, 243, -1, 246, 248, 250, 252, 254, 256, 258, -1, 260, 262, 264, 266, 268, -1, 271, 273, 275, 277, 279, 281, 283, -1, -1, 287, -1, 290, 291, -1, 294, 296, 298, 300, 302, -1, 304, 306, 308, 309, 311, 313, 315, -1, 318, 320, 322, 324, 326, 328, 330, 332, 334, 336, 338, 340, 342, 344, 346, 348, 350, 352, 354, 356, 358, 360, 362, 364, 366, 368, 370, 371, 373, 374, -1, 376, 378, 380, 382, 384, 386, 388, 390, -1, 393, 395, 397, 399, -1, 402, 404, 406, 408, 410, -1, 413, 415, 417, 419, 421, 423, 425, -1, 428, 430, 432, 434, -1, 437, 439, 441, 442, 444, -1, 447, -1, 450, 452, 454, 455, 457, 459, 461, 463, 464, 466, 468, 470, 472, 474, 476, 478, 480, 482, 484, 486, 488, -1, 491, 493, 495, 497, -1, -1, 501, 503, 505, 507, 508, 510, 512, 514, 516, 518, -1, 520, 522, 524, -1, 527, 529, 531, -1, 534, 536, 538, 540, 542, -1, 545, -1, 548, 550, 552, -1, 555, 557, 559, 561, 563, 565, 566, -1, 569, 571, -1, 574, 576, 578, 580, 582, 584, 586, 587, 589, 591, 593, 595, 596, -1, 599, 600, 602, 604, 606, 607, 609, -1, 612, 614, 616, 618, 620, 622, 624, 626, 628, 630, 632, -1, 635, 637, 639, 641, -1, 644, -1, 647, 649, 651, 653, 655, 657, 659, -1, 661, 663, 665, 667, 668, 669, -1, 671, 673, 675, 677, 679, 681, 683, 685, 687, 689, 691, 693, 695, 697, -1, 700, 702, 704, 706, 708, 710, 712, -1, 715, 717, 719, 721, 723, 725, 727, 729, 731, 733, 735, 737, 739, 741, 743, 745, 747, 749, 751, 753, 755, 757, 759, 761, 763, 765, 766, 768, 770, 772, 774, 776, 778, -1, 781, 783, 784, 786, -1, 789, 791, 793, 795, 797, 799, 801, 803, 805, 807, 809, 811, 813, 815, 817, 819, 820, 822, 824, 826, 828, 830, 832, -1, 835, 837, 839, 840, 842, 844, 846, -1, 849, 851, 853, 855, 857, 859, 861, 862, 864, 866, 868, 870, 872, -1, 875, 877, 879, 881, 882, 884, -1, 887, 889, 891, 893, 895, 897, 899, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		compareRunnableMethods(new ValidateBinaryTreeNodesPublic(), new ValidateBinaryTreeNodes(), sol -> loadTest(sol, leftChildren1, rightChildren1));
	}

	public void loadTest(IValidateBinaryTreeNodes1361 solution, int[] leftChildren, int[] rightChildren)
	{
		solution.validateBinaryTreeNodes(leftChildren.length, leftChildren, rightChildren);
	}

	@Test
	public void get()
	{
		BinaryTreeTestUtil.genBinaryTreeChildren(1000);
	}
}
